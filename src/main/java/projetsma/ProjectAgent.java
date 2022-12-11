package projetsma;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;

public class ProjectAgent extends Agent {
    private String service;
    protected void setup() {
        Object[] args = getArguments();
        service = (String) args[0];
        System.out.println("Bonjour nous sommes en en état d'urgence. Je suis "+this.getLocalName()+
                " je m'occupe de service: "+service);
        registerService();
    }
    private void registerService() {
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(this.getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType(service);
        sd.setName(service);
        dfd.addServices(sd);
        try {
            DFService.register(this, dfd);
        }
        catch (FIPAException e) {
            System.err.println(getLocalName() +
                    " registration with DF unsucceeded. Reason: " +
                    e.getMessage());
            doDelete();
        }
    }
}