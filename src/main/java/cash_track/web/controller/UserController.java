package cash_track.web.controller;


import cash_track.web.dto.request.CreateUserRq;
import cash_track.web.dto.response.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Tag(name = "User management API")
@RequestMapping("/users")
public interface UserController {

  @PostMapping
  @Operation(summary = "Create a user")
  ResponseDto<UUID> createUser(@Valid @RequestBody CreateUserRq request);
}
