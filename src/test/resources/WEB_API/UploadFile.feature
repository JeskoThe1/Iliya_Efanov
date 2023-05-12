Feature: upload file
  @upload
  Scenario: upload file to dropbox
    Given file "test.txt" exists
    When i upload file
    Then i check if file "test.txt" is uploaded