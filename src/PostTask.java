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
                    log.INFO("Usual correspondence: from " + mail.getFrom() + " to " + mail.getTo());
                }
            }
            return mail;
        }
    }


    public static class Thief implements MailService {
        private int minCostOfPackage;
        private int stolenValue = 0;

        public Thief(int minCostOfPackage) {
            this.minCostOfPackage = minCostOfPackage;

        }

        public int getStolenValue() {
            return stolenValue;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage && mail.getPrice() >= minCostOfPackage) {
                stolenValue += mail.getPrice();
                Package PackageCopy = new Package("stones instead of " + mail.getContent, 0);
            }
            return PackageCopy;
        }
    }


    public static class IllegalPackageException extends RuntimeException {
        public IllegalPackageException(String message) {
            super(message);
        }
    }


    public static class StolenPackageException extends RuntimeException {
        public StolenPackageException(String message) {
            super(message);
        }
    }


    public static class Inspector implements MailService {
        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage){
                if(mail.getContent().contains("stones")) {
                    throw new StolenPackageException("Камни в посылке!");
                }
                if(mail.getContent().contains(WEAPONS) || mail.getContent().contains(BANNED_SUBSTANCE)) {
                    throw new IllegalPackageException;
                }
            return mail;
        }
    }
}