@Regression
Feature: Process Customer Form in Front Recolecciones
  As a customer service representative
  I want to process and submit customer information through the Front Recolecciones form
  So that the customer’s request can be officially registered and processed by the system


  @RecoleccionesFrontTramiteFormulario
  Scenario Outline: Process customer form submission in Front Recolecciones
    Given is a Panama person <data>
    When the customer fills out all required fields in the form with valid and complete information
    Then the system should display a confirmation message indicating successful form submission and processing start
    Examples:
      | data                   |
      | Panama subsidiary data |