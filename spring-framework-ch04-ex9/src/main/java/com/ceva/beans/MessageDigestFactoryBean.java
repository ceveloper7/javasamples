package com.ceva.beans;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.security.MessageDigest;

public class MessageDigestFactoryBean implements FactoryBean<MessageDigest>, InitializingBean {
    private String algorithmName = "MD5";

    private MessageDigest messageDigest = null;

    /**
     * Spring llama este metodo para obtener el objeto MessageDigest creado por el FactoryBean
     */
    @Override
    public MessageDigest getObject() throws Exception {
        return messageDigest;
    }

    // el indicamos a Spring el tipo de objeto que retornara el FactoryBean
    @Override
    public Class<MessageDigest> getObjectType() {
        return MessageDigest.class;
    }

    // informamos a Spring que el FactoryBean esta administrado por una instancia singleton.
    public boolean isSingleton(){
        return true;
    }

    public void setAlgorithmName(String algorithmName){
        this.algorithmName = algorithmName;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // Creamos una instancia de MessageDigest
        messageDigest = MessageDigest.getInstance(algorithmName);
    }

}
