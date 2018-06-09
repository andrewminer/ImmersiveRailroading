package cam72cam.immersiverailroading.library;

import cam72cam.immersiverailroading.util.TextUtil;

public enum GuiText {
	LABEL_BRAKE("label.brake"),
	LABEL_THROTTLE("label.throttle"),
	SELECTOR_TYPE("selector.type"),
	SELECTOR_QUARTERS("selector.quarters"),
	SELECTOR_RAIL_BED("selector.rail_bed"),
	SELECTOR_RAIL_BED_FILL("selector.rail_bed_fill"),
	SELECTOR_POSITION("selector.position"),
	SELECTOR_DIRECTION("selector.direction"),
	SELECTOR_PLACE_BLUEPRINT("selector.place_blueprint"),
	SELECTOR_GAUGE("selector.gauge"),
	SELECTOR_PLATE_TYPE("selector.plate_type"),
	SELECTOR_PLATE_BOILER("selector.plate_boiler"),
	SELECTOR_CAST_SINGLE("selector.cast_single"),
	SELECTOR_CAST_REPEAT("selector.cast_repeat"),
	SELECTOR_PLACE_EMBANKMENT("selector.place_embankment"),

	TRACK_TYPE("track.type"),
	TRACK_LENGTH("track.length"),
	TRACK_GAUGE("track.gauge"),
	TRACK_QUARTERS("track.quarters"),
	TRACK_RAIL_BED("track.rail_bed"),
	TRACK_RAIL_BED_FILL("track.rail_bed_fill"),
	TRACK_POSITION("track.position"),
	TRACK_DIRECTION("track.direction"),
	TRACK_PLACE_BLUEPRINT_TRUE("track.place_blueprint_true"),
	TRACK_PLACE_BLUEPRINT_FALSE("track.place_blueprint_false"),
	TRACK_PLACE_EMBANKMENT_TRUE("track.place_embarkment_true"),
	TRACK_PLACE_EMBANKMENT_FALSE("track.place_embarkment_false"),
	
	LOCO_WORKS("loco.works"),
	LOCO_HORSE_POWER("loco.horse_power"),
	LOCO_TRACTION("loco.tractive_effort"),
	LOCO_MAX_SPEED("loco.max_speed"),
	GAUGE_TOOLTIP("stock.gauge"),
	RAW_CAST_TOOLTIP("cast.raw"),
	TANK_CAPACITY_TOOLTIP("stock.tank_capacity"),
	FREIGHT_CAPACITY_TOOLTIP("stock.freight_capacity"),
	WEIGHT_TOOLTIP("stock.weight"),
	
	NONE("none"),
	;
	
	private String value;
	GuiText(String value) {
		this.value = value;
	}
	
	public String getRaw() {
		return "gui.immersiverailroading:" + value;
	}

	@Override
	public String toString() {
		return TextUtil.translate(getRaw());
	}
	
	public String toString(Object...objects) {
		return TextUtil.translate(getRaw(), objects);
	}
}
