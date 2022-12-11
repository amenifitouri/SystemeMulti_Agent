package projetsma;
import jade.core.Agent;
public class ReceiverAgent extends Agent {
    protected void setup() {
        System.out.println("Bonjour , je suis:"+this.getLocalName());
        addBehaviour(new ReceiverBehaviour(this));
    }
}