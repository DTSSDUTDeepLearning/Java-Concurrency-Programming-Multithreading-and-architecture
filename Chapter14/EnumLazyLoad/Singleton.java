package Chapter14.EnumLazyLoad;

public class Singleton {

    private byte[] data = new byte[1024];

    private Singleton() {}

    private enum EnumHolder {
        INSTANCE;

        private Singleton instance;

        EnumHolder() {
            this.instance = new Singleton();
        }

        private Singleton getSingleton() {
            return instance;
        }
    }

    public static Singleton getInstance() {
        return EnumHolder.INSTANCE.getSingleton();
    }
}
