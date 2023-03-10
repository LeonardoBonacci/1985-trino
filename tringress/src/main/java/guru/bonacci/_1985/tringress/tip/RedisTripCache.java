package guru.bonacci._1985.tringress.tip;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@RequiredArgsConstructor
public class RedisTripCache implements TripCache {
  
  @Value("${spring.mvc.async.request-timeout}")
  private Long ttlInMs;

  private final StringRedisTemplate redis;


  public Boolean lock(String lockId) {
    boolean newKey = redis.opsForValue().setIfAbsent(lockId, lockId, Duration.ofMillis(ttlInMs));
    log.info("new lock {}: {}", lockId, newKey);
    return newKey;
  }
}