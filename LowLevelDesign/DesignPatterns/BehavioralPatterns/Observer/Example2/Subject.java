package LowLevelDesign.DesignPatterns.BehavioralPatterns.Observer.Example2;

interface Subject {
    void subscribe(Observer ob);

    void unsubscribe(Observer ob);

    void newVideoUpload(String title);
}
