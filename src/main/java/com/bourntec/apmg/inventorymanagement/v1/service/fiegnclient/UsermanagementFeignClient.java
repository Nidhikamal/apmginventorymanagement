package com.bourntec.apmg.inventorymanagement.v1.service.fiegnclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "apmgusermanagement")
public interface UsermanagementFeignClient {
	@GetMapping("/usermanagement/v1/VenderStateCodes/{stateCode}")
	Object findStatecodeById(@PathVariable String stateCode);
}
