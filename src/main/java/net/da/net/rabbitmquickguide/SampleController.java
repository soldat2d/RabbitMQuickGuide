package net.da.net.rabbitmquickguide;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    private final Logger logger = LoggerFactory.getLogger(SampleController.class);

    private final AmqpTemplate template;

    @Autowired
    public SampleController(AmqpTemplate template) {
        this.template = template;
    }

    @PostMapping("/emit")
    public ResponseEntity<String> emit(@RequestBody SimpleMessage simpleMessage) {
        logger.info("Emit to myQueue");
        for (int i = 0; i < 10; i++) {
            template.convertAndSend("myQueue", simpleMessage.getMessage());
        }
        return ResponseEntity.ok("Success emit to queue");
    }
}
