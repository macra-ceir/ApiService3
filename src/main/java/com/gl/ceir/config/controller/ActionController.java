package com.gl.ceir.config.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gl.ceir.config.model.app.Action;
import com.gl.ceir.config.service.ActionService;

//import io.swagger.annotations.ApiOperation;
@RestController
public class ActionController {

    @Autowired
    private ActionService actionService;

    //@ApiOperation(value = "View All available Action ", response = Action.class, responseContainer = "list")
    @RequestMapping(path = "/Action/", method = RequestMethod.GET)
    public MappingJacksonValue getAll() {
        List<Action> allActions = actionService.getAll();

        MappingJacksonValue mapping = new MappingJacksonValue(allActions);
        return mapping;
    }

    // @RequestMapping(path = "/Action/{id}", method = RequestMethod.GET)
    public MappingJacksonValue get(@PathVariable(value = "id") Long id) {
        Action action = actionService.get(id);
        MappingJacksonValue mapping = new MappingJacksonValue(action);
        return mapping;
    }

    // @RequestMapping(path = "/Action/", method = RequestMethod.POST)
    public MappingJacksonValue save(@RequestBody Action action) {
        Action savedAction = actionService.save(action);
        MappingJacksonValue mapping = new MappingJacksonValue(savedAction);
        return mapping;
    }

    // @RequestMapping(path = "/Action/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id) {
        actionService.delete(id);
    }

    // @RequestMapping(path = "/Action/{id}", method = RequestMethod.PUT)
    public MappingJacksonValue update(@PathVariable(value = "id") Long id, @RequestBody Action action) {
        Action updatedAction = actionService.update(action);
        MappingJacksonValue mapping = new MappingJacksonValue(updatedAction);
        return mapping;
    }
}
