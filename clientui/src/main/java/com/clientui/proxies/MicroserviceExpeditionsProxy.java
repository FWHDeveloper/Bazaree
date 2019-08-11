package com.clientui.proxies;

import com.clientui.beans.ExpeditionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "zuul-server")
@RibbonClient(name = "microservice-expeditions")

public interface MicroserviceExpeditionsProxy {

    @GetMapping(value = "/microservice-expeditions/expeditions")
    List<ExpeditionBean> listeDesExpeditions();

    @GetMapping( value = "/microservice-expeditions/Expeditions/{id}")
    ExpeditionBean etatExpedition(@PathVariable("id") int id);
}
