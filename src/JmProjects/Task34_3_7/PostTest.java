package JmProjects.Task34_3_7;

import java.util.logging.*;

public class PostTest {
    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";
/** ========================================================================== */
    /**
     * Интерфейс: сущность, которую можно отправить по почте.
     * У такой сущности можно получить от кого и кому направляется письмо.
     */
    public static interface Sendable {
        String getFrom();

        String getTo();
    }
/** ========================================================================== */
    /**
     * Абстрактный класс,который позволяет абстрагировать логику хранения
     * источника и получателя письма в соответствующих полях класса.
     */
    public static abstract class AbstractSendable implements Sendable {
        protected final String from;
        protected final String to;

        public AbstractSendable(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AbstractSendable that = (AbstractSendable) o;

            if (!from.equals(that.from)) return false;
            if (!to.equals(that.to)) return false;

            return true;
        }
    }
    /** ========================================================================== */
    /**
     * Письмо, у которого есть текст, который можно получить с помощью метода `getMessage`
     */

    public static class MailMessage extends AbstractSendable {
        private final String message;

        public MailMessage(String from, String to, String message) {
            super(from, to);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailMessage that = (MailMessage) o;

            if (message != null ? !message.equals(that.message) : that.message != null) return false;

            return true;
        }
    }
    /** ========================================================================== */
    /**
     * Посылка, содержимое которой можно получить с помощью метода `getContent`
     */
    public static class MailPackage extends AbstractSendable {
        private final Package content;

        public MailPackage(String from, String to, Package content) {
            super(from, to);
            this.content = content;
        }

        public Package getContent() {     //ссылка на тип еласса Package
            return content;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailPackage that = (MailPackage) o;

            if (!content.equals(that.content)) return false;

            return true;
        }
    }
    /** ========================================================================== */
    /**
     * Класс, который задает посылку. У посылки есть текстовое описание содержимого и целочисленная ценность.
     */
    public static class Package {
        private final String content;
        private final int price;

        public Package(String content, int price) {
            this.content = content;
            this.price = price;
        }

        public String getContent() {
            return content;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Package aPackage = (Package) o;

            if (price != aPackage.price) return false;
            if (!content.equals(aPackage.content)) return false;

            return true;
        }
    }

    /** ========================================================================== */
    /**
     * Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект.
     */
    public static interface MailService {
        Sendable processMail(Sendable mail);
    }

    /* ========================================================================== */
    /*
     * Класс, в котором скрыта логика настоящей почты
     */
    public static class RealMailService implements MailService {
        @Override
        public Sendable processMail(Sendable mail) {
            // Здесь описан код настоящей системы отправки почты.
            return mail;
        }
    }


    /*
     * Вам необходимо описать набор классов, каждый из которых является MailService:
     * <p>
     * 1) UntrustworthyMailWorker – класс, моделирующий ненадежного работника почты, который вместо того,
     * чтобы передать почтовый объект непосредственно в сервис почты, последовательно передает этот
     * объект набору третьих лиц, а затем, в конце концов, передает получившийся объект непосредственно
     * экземпляру RealMailService. У UntrustworthyMailWorker должен быть конструктор от массива
     * MailService ( результат вызова processMail первого элемента массива передается на вход processMail
     * второго элемента, и т. д.) и метод getRealMailService, который возвращает ссылку на внутренний
     * экземпляр RealMailService.
     */

    public static class UntrustworthyMailWorker implements MailService {

        protected final MailService[] mailServices;
        protected final RealMailService innerInstanceRealMailService;

        public UntrustworthyMailWorker(MailService[] mailServices) {
            this.mailServices = mailServices;
            this.innerInstanceRealMailService = new RealMailService();
        }

        @Override
        public Sendable processMail(Sendable mail) {
            for (MailService mailService : mailServices) {
                mail = mailService.processMail(mail);
            }
            return innerInstanceRealMailService.processMail(mail);
        }

        public MailService getRealMailService() {        // getRealMailService, который возвращает ссылку на внутренний
            return this.innerInstanceRealMailService;                                   // экземпляр RealMailService
        }
    }

    /*
     * ==========================================================================
     * 2) Spy – шпион, который логгирует о всей почтовой переписке, которая проходит через его руки.
     * Объект конструируется от экземпляра Logger, с помощью которого шпион будет сообщать о всех
     * действиях. Он следит только за объектами класса MailMessage и пишет в логгер следующие
     * сообщения (в выражениях нужно заменить части в фигурных скобках на значения полей почты):
     * 2.1) Если в качестве отправителя или получателя указан "Austin Powers", то нужно написать
     * в лог сообщение с уровнем WARN: Detected target mail correspondence: from {from} to {to} "{message}"
     * 2.2) Иначе, необходимо написать в лог сообщение с уровнем INFO: Usual correspondence: from {from} to {to}
     */

    public static class Spy implements MailService {
        private Logger spyLogger;

        public Spy(Logger spyLogger) {

            this.spyLogger = spyLogger;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailMessage) {
                if (mail.getFrom().equals(AUSTIN_POWERS) || mail.getTo().equals(AUSTIN_POWERS)) {
                    spyLogger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                            new Object[]{mail.getFrom(), mail.getTo(), ((MailMessage) mail).getMessage()});
                } else {
                    spyLogger.log(Level.INFO, "Usual correspondence: from {0} to {1}",
                            new Object[]{mail.getFrom(), mail.getTo()});
                }
            }
            return mail;
        }
    }

    /**
     * ==========================================================================
     * 3) Thief – вор, который ворует самые ценные посылки и игнорирует все остальное. Вор принимает
     * в конструкторе переменную int – минимальную стоимость посылки, которую он будет воровать.
     * Также, в данном классе должен присутствовать метод getStolenValue, который возвращает суммарную
     * стоимость всех посылок, которые он своровал. Воровство происходит следующим образом: вместо
     * посылки, которая пришла вору, он отдает новую, такую же, только с нулевой ценностью и содержимым
     * посылки "stones instead of {content}".
     */

    public static class Thief implements MailService {
        private static int StolenPrice;
        private static int MinValue;

        public Thief(int m) {
            this.MinValue = m;
        }

        public int getStolenValue() {
            return StolenPrice;
        }

        MailPackage mailPackage;

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                if (((MailPackage) mail).getContent().getPrice() >= MinValue) {
                    StolenPrice += ((MailPackage) mail).getContent().getPrice();
                    return new MailPackage(mail.getFrom(), mail.getTo(),
                            new Package("stones instead of " + (((MailPackage) mail)
                                    .getContent().getContent()), 0));
                } else {
                    return mail;
                }
            }
            return mail;
        }
    }

    /*
     * ==========================================================================
     * 4) Inspector – Инспектор, который следит за запрещенными и украденными посылками и бьет тревогу
     * в виде исключения, если была обнаружена подобная посылка. Если он заметил запрещенную посылку
     * с одним из запрещенных содержимым ("weapons" и "banned substance"), то он бросает IllegalPackageException.
     * Если он находит посылку, состоящую из камней (содержит слово "stones"), то тревога прозвучит
     * в виде StolenPackageException. Оба исключения вы должны объявить самостоятельно в виде непроверяемых исключений.
     */

    public static class Inspector implements MailService {

//        MailPackage mailPackage = (MailPackage) mail; // приводим тип Sendable к MailPackage
//        Package package = mailPackage.getContent(); // получаем саму посылку из ее обертки
//        String packageContent = package.getContent(); // получаем ее содержимое
//          (MailPackage) mail).getContent().getContent()

        String mailContent;

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                mailContent = (((MailPackage) mail).getContent().getContent());
                if (mailContent.contains(WEAPONS) || mailContent.contains(BANNED_SUBSTANCE)) {
                    throw new IllegalPackageException();
                } else if (mailContent.contains("stones")) {
                    throw new StolenPackageException();
                }
            }
            return mail;
        }


    }

    /*
     * ===================== КЛАССЫ ИСКЛЮЧЕНИЙ ====================================================
     */
    public static class StolenPackageException extends RuntimeException {
        public StolenPackageException() {
        }
    }

    public static class IllegalPackageException extends RuntimeException {
        public IllegalPackageException() {
        }
    }

    /* ==========================================================================
     *Все классы должны быть определены как публичные и статические, так как в процессе проверки
     * ваш код будет подставлен во внешний класс, который занимается тестированием и проверкой
     * структуры. Для удобства во внешнем классе объявлено несколько удобных констант и импортировано
     * все содержимое пакета java.util.logging. Для определения, посылкой или письмом является
     * Sendable объект воспользуйтесь оператором instanceof. */

    /** =============== ДАЛЕЕ То ЧТО ПРОШЛО ТЕСТ =========================================================== */
}
//
//public static class UntrustworthyMailWorker implements PostTest.MailService {
//
//    private final PostTest.RealMailService realService = new PostTest.RealMailService();
//    private final PostTest.MailService[] mServices;
//
//    public UntrustworthyMailWorker(PostTest.MailService[] mServices) {
//        this.mServices = mServices;
//    }
//
//    public PostTest.MailService getRealMailService() {
//        return realService;
//    }
//
//    @Override
//    public PostTest.Sendable processMail(PostTest.Sendable mail) {
//        for (PostTest.MailService mailWorker : mServices) {
//            mail = mailWorker.processMail(mail);
//        }
//        return realService.processMail(mail);
//    }
//}
//
//public static class Spy implements PostTest.MailService {
//    private Logger logger;
//
//    public Spy(Logger logger) {
//        this.logger = logger;
//    }
//
//    @Override
//    public PostTest.Sendable processMail(PostTest.Sendable mail) {
//        if (mail instanceof PostTest.MailMessage) {
//            if (mail.getFrom().equals(AUSTIN_POWERS) || mail.getTo().equals(AUSTIN_POWERS)) {
//                logger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
//                        new Object[]{mail.getFrom(), mail.getTo(), ((PostTest.MailMessage) mail).getMessage()});
//            } else {
//                logger.log(Level.INFO, "Usual correspondence: from {0} to {1}",
//                        new Object[]{mail.getFrom(), mail.getTo()});
//            }
//        }
//        return mail;
//    }
//}
//
//public static class Thief implements PostTest.MailService {
//    private final int price;
//    private int StolenValue;
//
//    public Thief(int price) {
//        this.price = price;
//    }
//
//    @Override
//    public PostTest.Sendable processMail(PostTest.Sendable mail) {
//
//        if (mail instanceof PostTest.MailPackage) {
//            PostTest.MailPackage mailPackage = (PostTest.MailPackage) mail;
//
//            if (mailPackage.getContent().getPrice() >= price) {
//                StolenValue += mailPackage.getContent().getPrice();
//                return new PostTest.MailPackage(mailPackage.getFrom(),
//                        mailPackage.getTo(),
//                        new PostTest.Package("stones instead of " +
//                                mailPackage.getContent().getContent(),
//                                0));
//            }
//        }
//        return mail;
//    }
//
//    public int getStolenValue() {
//        return StolenValue;
//    }
//}
//
//public static class Inspector implements PostTest.MailService {
//
//    String mailContent;
//
//    @Override
//    public PostTest.Sendable processMail(PostTest.Sendable mail) {
//        if (mail instanceof PostTest.MailPackage) {
//            mailContent = (((PostTest.MailPackage) mail).getContent().getContent());
//            if (mailContent.contains(WEAPONS) || mailContent.contains(BANNED_SUBSTANCE)) {
//                throw new PostTest.IllegalPackageException();
//            } else if (mailContent.contains("stones")) {
//                throw new PostTest.StolenPackageException();
//            }
//        }
//        return mail;
//    }
//}
//
//public static class StolenPackageException extends RuntimeException {
//    public StolenPackageException() {
//    }
//}
//
//public static class IllegalPackageException extends RuntimeException {
//    public IllegalPackageException() {
//    }
//}