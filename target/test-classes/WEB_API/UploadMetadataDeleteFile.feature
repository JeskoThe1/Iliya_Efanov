Feature: upload file
  Background:
    Given file "test.txt" exists
    Then i upload file
  @upload
  Scenario: upload file to dropbox
    Then i check if file "test.txt" is uploaded

  Scenario: get metadata from file in dropbox
    Given file "test.txt" exists in dropbox
    When I get file's meta data
    Then I check if I received file's data

  Scenario: delete file from dropbox
    Given I check if "test.txt" exists
    When I delete file
    Then I check if file is deleted