package me.example.springgson.dto;

public class ResponseDto {
  private String testData = "s";
  private String testData2;

  public String getTestData() {
    return testData;
  }

  public void setTestData(String testData) {
    this.testData = testData;
  }

  public String getTestData2() {
    return testData2;
  }

  public void setTestData2(String testData2) {
    this.testData2 = testData2;
  }
}
