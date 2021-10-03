package com.example.soapside.aeroConfig;

import com.aerospike.client.Host;
import com.example.soapside.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.aerospike.config.AbstractAerospikeDataConfiguration;
import org.springframework.data.aerospike.repository.config.EnableAerospikeRepositories;

import java.util.Collection;
import java.util.Collections;

@Configuration
@EnableConfigurationProperties(AerospikeConfigProper.class)
@EnableAerospikeRepositories(basePackageClasses = UserRepository.class)
public class AerospikeConfig extends AbstractAerospikeDataConfiguration {

    @Autowired
    private  AerospikeConfigProper aerospikeConfigProper;

    @Override
    protected Collection<Host> getHosts(){
        return Collections.singleton(new Host(aerospikeConfigProper.getHost(),
                aerospikeConfigProper.getPort()));
    }

    @Override
    protected String nameSpace(){
        return aerospikeConfigProper.getNamespace();
    }





}
