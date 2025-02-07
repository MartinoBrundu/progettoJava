package controller;

import entities.Device;
import exceptions.BadRequestException;
import payloads.DeviceAssignementDTO;
import payloads.DeviceDTO;
import payloads.NewDeciveDTO;
import services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping
    private Page<Device> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
        return deviceService.findAll(page, size, sortBy);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Device save(@RequestBody @Validated NewDeciveDTO payload, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        }
        return deviceService.save(payload);
    }

    @GetMapping("/{id}")
    private Device findById(@PathVariable long id) {
        return deviceService.findById(id);
    }

    @PutMapping("/{id}")
    private Device findByIdAndUpdate(@PathVariable long id, @RequestBody @Validated DeviceDTO payload, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        }
        return deviceService.findByIdAndUpdateStatus(id, payload);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void findByIdAndDelete(@PathVariable long id) {
        deviceService.findByIdAndDelete(id);
    }

    @PutMapping("/assignement/{id}")
    private Device findByIdAndAssign(@PathVariable long id, @RequestBody DeviceAssignementDTO payload, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        }
        return deviceService.findByIdAndAssign(id, payload);
    }
}