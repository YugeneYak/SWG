package builder;

import java.util.HashMap;
import java.util.Map;

public final class FieldsBuilder {

    private Map<String, String> params;

    private FieldsBuilder(FieldsBuilder.Builder builder){
        this.params = builder.buildParams;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public static class Builder{
        private Map<String, String> buildParams = new HashMap<>();

        public FieldsBuilder.Builder addParam(String key, String value){
            buildParams.put(key, value);
            return this;
        }

        public FieldsBuilder build(){
            return new FieldsBuilder(this);
        }
    }
}