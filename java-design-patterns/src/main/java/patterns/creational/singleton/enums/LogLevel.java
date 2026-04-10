package patterns.creational.singleton.enums;

public enum LogLevel {
    DEBUG(10, "DEBUG"),
    INFO(6, "INFO"),
    WARNING(3, "WARNING"),
    ERROR(1, "ERROR");

    private int level;
    private String name;

    LogLevel(int level, String name){
        this.level = level;
        this.name = name;
    }

    public int getLevel(){
        return level;
    }

    public String getName(){
        return name;
    }

    public String getLogAcronym(){
        return (name + ": ").intern();
    }
}
