package cam72cam.immersiverailroading.net;

import cam72cam.immersiverailroading.items.ItemRail;
import cam72cam.immersiverailroading.library.TrackItems;
import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemRailUpdatePacket implements IMessage {
	private int slot;
	private int length;
	private int quarters;
	private TrackItems type;
	
	public ItemRailUpdatePacket() {
		// For Reflection
	}
	
	@SideOnly(Side.CLIENT)
	public ItemRailUpdatePacket(int slot, int length, int quarters, TrackItems type) {
		this.slot = slot;
		this.length = length;
		this.quarters = quarters;
		this.type = type;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.length = buf.readInt();
		this.slot = buf.readInt();
		this.quarters = buf.readInt();
		this.type = TrackItems.fromMeta(buf.readInt());
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(length);
		buf.writeInt(slot);
		buf.writeInt(quarters);
		buf.writeInt(type.getMeta());
	}
	
	public static class Handler implements IMessageHandler<ItemRailUpdatePacket, IMessage> {
		@Override
		public IMessage onMessage(ItemRailUpdatePacket message, MessageContext ctx) {
			FMLCommonHandler.instance().getWorldThread(ctx.netHandler).addScheduledTask(() -> handle(message, ctx));
			return null;
		}

		private void handle(ItemRailUpdatePacket message, MessageContext ctx) {
			ItemStack stack = ctx.getServerHandler().player.inventory.getStackInSlot(message.slot);
			ItemRail.setLength(stack, message.length);
			ItemRail.setQuarters(stack, message.quarters);
			stack.setItemDamage(message.type.getMeta());
			ctx.getServerHandler().player.inventory.setInventorySlotContents(message.slot, stack);
		}
	}
}
