package projetsma;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
public class BlockingAgent extends Agent {
    protected void setup() {
        System.out.println("Bonjour,  je suis :"+this.getLocalName());
        System.out.println("Waiting for message ...");
        ACLMessage msg = blockingReceive();
        System.out.println("Received message: "+msg.toString());
    }}