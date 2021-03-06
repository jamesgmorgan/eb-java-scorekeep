package scorekeep;

import java.util.concurrent.atomic.AtomicLong;
import java.util.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.security.SecureRandom;
import java.math.BigInteger;

@RestController
@RequestMapping(value="/api/rules")
public class RulesController {
  private SecureRandom random = new SecureRandom();
  private RulesFactory rulesFactory = new RulesFactory();

  /* GET /rules */
  @RequestMapping(method=RequestMethod.GET)
  public Collection<Rules> rules() {
    return rulesFactory.getAllRules();
  }
  /* GET /rules/RULES */
  @RequestMapping(value="/{rulesId}",method=RequestMethod.GET)
  public Rules rules(@PathVariable String rulesId) {
    return rulesFactory.getRules(rulesId);
  }
}
