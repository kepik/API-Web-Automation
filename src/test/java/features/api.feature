@api
Feature: API Test

  @api-get-data
  Scenario: test get list data
    Given prepare url for "GET_LIST_USERS"
    And hit api get list users
    Then validate status code is equal 200
    Then validate response body get list users
    Then validate response json schema "get_list_users_schema.json"

  @api-create-data
  Scenario: test create user data
    Given prepare url for "CREATE_NEW_USER"
    And hit api post create new user
    Then validate status code is equal 200
    Then validate response body post create user
    Then validate response json schema "post_create_new_user_schema.json"

  @api-update-data
  Scenario: test update user data
    Given prepare url for "CREATE_NEW_USER"
    And hit api post create new user
    Then validate response body post create user
    Given prepare url for "UPDATE_USER_DATA"
    And hit api put update user data
    Then validate status code is equal 200
    Then validate response body put update user
    Then validate response json schema "put_update_user_schema.json"

  @api-delete-data
  Scenario: test delete user data
    Given prepare url for "CREATE_NEW_USER"
    And hit api post create new user
    Then validate response body post create user
    Given prepare url for "DELETE_USER"
    And hit api delete user data
    Then validate status code is equal 200

  @api-get-tag
  Scenario: test get list data
    Given prepare url for "GET_LIST_TAG"
    And hit api get list users
    Then validate status code is equal 200
    Then validate response json schema "get_list_tags_schema.json"