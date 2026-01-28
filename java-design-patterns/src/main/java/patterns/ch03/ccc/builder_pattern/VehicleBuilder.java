package patterns.ch03.ccc.builder_pattern;

public final class VehicleBuilder {
    static  Vehicle buildSlowVehicle(){
        var engine = new RecordPart("engine");
        var cabin = new StandardPart("cabin");
        return new SlowVehicle(engine, cabin);
    }
}
