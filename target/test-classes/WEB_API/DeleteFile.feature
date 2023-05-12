Feature: Delete file
  @delete
  Scenario: delete file from dropbox
    Given I check if "test.txt" exists
    When I delete file
    Then I check if file is deleted