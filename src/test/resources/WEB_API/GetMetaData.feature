Feature: get metadata from file
  @metadata
  Scenario: get metadata from file in dropbox
    Given file "test.txt" exists in dropbox
    When I get file's meta data
    Then I check if I recieved file's data