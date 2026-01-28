package patterns.ch03.ccc.builder_pattern;

public class StandardPart implements Part{
    private final String name;

    public StandardPart(String name){
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }
}
