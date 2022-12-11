package projetsma;
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
public class SenderAgent extends Agent {
    protected void setup() {
        System.out.println("Bonjour , je suis :"+this.getLocalName());
        sendMessage();
    }
    private void sendMessage() {
        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        msg.addReceiver(new AID("ambulance1",AID.ISLOCALNAME));
        msg.setContent("Fait attention! il y a une coupure de la route");
        send(msg);
    }

}
