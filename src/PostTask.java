import java.util.logging.Logger;

public class PostTask {

    public static class UntrustworthyMailWorker implements MailService {
        private final MailService[] mail;
        private RealMailService rms = new RealMailService();

        public UntrustworthyMailWorker(MailService[] mail) {
            this.mail = mail;
        }

        public RealMailService getRms() {
            return rms;
        }

        @Override
        public Sendable processMail(Sendable mail) {

            return mail;
        }
    }


    public static class Spy implements MailService {
        private Logger log;

        public Spy(Logger log) {
            this.log = log;
        }


        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailMessage) {
                if (mail.getFrom() == "Austin Powers" || mail.getTo() == "Austin Powers") {
                    log.WARN("Detected target mail correspondence: from " + mail.getFrom() + " to " + mail.getTo() + " " + mail.getMMessage());
                } else {
                    log.info("Usual correspondence: from " + mail.getFrom() + " to " + mail.getTo());
                }
            }
            return mail;
        }
    }


    public static class Thief  implements MailService {
        private int minCostOfPackage;
        static int stolenValue;

        public Thief(int minCostOfPackage){
            this.minCostOfPackage = minCostOfPackage;

        }

        public int getStolenValue(){
            return stolenValue;
        }

        @Override
        public Sendable processMail(Sendable mail) {

            return mail;
        }
    }
}