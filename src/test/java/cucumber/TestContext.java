package cucumber;

public class TestContext {

    public String stepInfo;
    public ScenarioContext scenarioContext;

    public TestContext(){
        scenarioContext = new ScenarioContext();
    }
}
