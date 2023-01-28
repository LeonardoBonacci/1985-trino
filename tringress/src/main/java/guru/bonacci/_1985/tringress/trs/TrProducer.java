package guru.bonacci._1985.tringress.trs;

import org.springframework.data.util.Pair;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TrProducer {

	public static final String TRANSFER_TOPIC = "transfers_for_";
	
  private final KafkaTemplate<String, Tr> kafkaTemplate;

  public Tr send(Pair<String, Tr> transferContext) {
  	var transfer = transferContext.getSecond();
    long timestamp = sendMessage(transferContext.getFirst() + TRANSFER_TOPIC, transfer.getFrom(), transfer);
    transfer.setWhen(timestamp);
    return transfer;
  }
 
  // exposed for testing
  long sendMessage(String topic, String key, Tr message) {
    try {
      return kafkaTemplate.send(topic, key, message).get().getRecordMetadata().timestamp();
    } catch (Throwable t) {
      t.printStackTrace();
      return -1;
    }
  }
}