package tech.jhipster.lite.generator.server.springboot.logstash.tcp.infrastructure.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.jhipster.lite.generator.project.domain.Project;
import tech.jhipster.lite.generator.project.infrastructure.primary.dto.ProjectDTO;
import tech.jhipster.lite.generator.server.springboot.logstash.tcp.application.LogstashApplicationService;

@RestController
@RequestMapping("/api/servers/spring-boot/logging/logstash/tcp")
@Tag(name = "Spring Boot - Logging")
class LogstashResource {

  private final LogstashApplicationService logstashApplicationService;

  public LogstashResource(LogstashApplicationService logstashApplicationService) {
    this.logstashApplicationService = logstashApplicationService;
  }

  @Operation(summary = "Add Logstash TCP appender")
  @ApiResponse(responseCode = "500", description = "An error occurred while adding Logstash TCP appender")
  @PostMapping
  public void init(@RequestBody ProjectDTO projectDTO) {
    Project project = ProjectDTO.toProject(projectDTO);
    logstashApplicationService.init(project);
  }
}
