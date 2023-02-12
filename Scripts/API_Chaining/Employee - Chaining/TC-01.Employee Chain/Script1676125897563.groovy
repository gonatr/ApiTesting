import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

response = WS.sendRequest(findTestObject('Employee/01.Save Employee'))

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(response.getResponseBodyContent())

String apiPostLoanResponse = response.getResponseText()

def value1 = result.employeeId

GlobalVariable.employeeId = value1

WS.sendRequestAndVerify(findTestObject('Employee/02.Employee Detail'))

WS.sendRequestAndVerify(findTestObject('Employee/03.Update Employee Detail', [('id') : GlobalVariable.employeeId]))

GlobalVariable.nationality = 'Indonesian'

response1 = WS.sendRequestAndVerify(findTestObject('Employee/02.Employee Detail', [('nationality') : GlobalVariable.nationality]))

def slurper1 = new groovy.json.JsonSlurper()

def result1 = slurper1.parseText(response1.getResponseBodyContent())

String apiPostLoanResponse1 = response1.getResponseText()

def value2 = result1.nationality

GlobalVariable.nationality = value2

String jsonSchema = '\n{\n    "$schema": "https://json-schema.org/draft/2019-09/schema",\n    "$id": "http://example.com/example.json",\n    "type": "object",\n    "default": {},\n    "title": "Root Schema",\n    "required": [\n        "data",\n        "rels"\n    ],\n    "properties": {\n        "data": {\n            "type": "object",\n            "default": {},\n            "title": "The data Schema",\n            "required": [\n                "firstName",\n                "middleName",\n                "lastName",\n                "code",\n                "employeeId",\n                "fullName",\n                "status",\n                "dob",\n                "driversLicenseNumber",\n                "licenseExpiryDate",\n                "maritalStatus",\n                "gender",\n                "otherId",\n                "nationality",\n                "unit",\n                "jobTitle",\n                "supervisor"\n            ],\n            "properties": {\n                "firstName": {\n                    "type": "string",\n                    "default": "",\n                    "title": "The firstName Schema",\n                    "examples": [\n                        "Megan"\n                    ]\n                },\n                "middleName": {\n                    "type": "string",\n                    "default": "",\n                    "title": "The middleName Schema",\n                    "examples": [\n                        "Ult"\n                    ]\n                },\n                "lastName": {\n                    "type": "string",\n                    "default": "",\n                    "title": "The lastName Schema",\n                    "examples": [\n                        "Van"\n                    ]\n                },\n                "code": {\n                    "type": "string",\n                    "default": "",\n                    "title": "The code Schema",\n                    "examples": [\n                        "0027"\n                    ]\n                },\n                "employeeId": {\n                    "type": "string",\n                    "default": "",\n                    "title": "The employeeId Schema",\n                    "examples": [\n                        "116"\n                    ]\n                },\n                "fullName": {\n                    "type": "string",\n                    "default": "",\n                    "title": "The fullName Schema",\n                    "examples": [\n                        "Megan Ult Van"\n                    ]\n                },\n                "status": {\n                    "type": "null",\n                    "default": null,\n                    "title": "The status Schema",\n                    "examples": [\n                        null\n                    ]\n                },\n                "dob": {\n                    "type": "null",\n                    "default": null,\n                    "title": "The dob Schema",\n                    "examples": [\n                        null\n                    ]\n                },\n                "driversLicenseNumber": {\n                    "type": "string",\n                    "default": "",\n                    "title": "The driversLicenseNumber Schema",\n                    "examples": [\n                        ""\n                    ]\n                },\n                "licenseExpiryDate": {\n                    "type": "null",\n                    "default": null,\n                    "title": "The licenseExpiryDate Schema",\n                    "examples": [\n                        null\n                    ]\n                },\n                "maritalStatus": {\n                    "type": "null",\n                    "default": null,\n                    "title": "The maritalStatus Schema",\n                    "examples": [\n                        null\n                    ]\n                },\n                "gender": {\n                    "type": "null",\n                    "default": null,\n                    "title": "The gender Schema",\n                    "examples": [\n                        null\n                    ]\n                },\n                "otherId": {\n                    "type": "string",\n                    "default": "",\n                    "title": "The otherId Schema",\n                    "examples": [\n                        ""\n                    ]\n                },\n                "nationality": {\n                    "type": "string",\n                    "default": "",\n                    "title": "The nationality Schema",\n                    "examples": [\n                        "Indonesian"\n                    ]\n                },\n                "unit": {\n                    "type": "null",\n                    "default": null,\n                    "title": "The unit Schema",\n                    "examples": [\n                        null\n                    ]\n                },\n                "jobTitle": {\n                    "type": "null",\n                    "default": null,\n                    "title": "The jobTitle Schema",\n                    "examples": [\n                        null\n                    ]\n                },\n                "supervisor": {\n                    "type": "null",\n                    "default": null,\n                    "title": "The supervisor Schema",\n                    "examples": [\n                        null\n                    ]\n                }\n            },\n            "examples": [{\n                "firstName": "Megan",\n                "middleName": "Ult",\n                "lastName": "Van",\n                "code": "0027",\n                "employeeId": "116",\n                "fullName": "Megan Ult Van",\n                "status": null,\n                "dob": null,\n                "driversLicenseNumber": "",\n                "licenseExpiryDate": null,\n                "maritalStatus": null,\n                "gender": null,\n                "otherId": "",\n                "nationality": "Indonesian",\n                "unit": null,\n                "jobTitle": null,\n                "supervisor": null\n            }]\n        },\n        "rels": {\n            "type": "object",\n            "default": {},\n            "title": "The rels Schema",\n            "required": [\n                "contact-detail",\n                "job-detail",\n                "dependent",\n                "supervisor"\n            ],\n            "properties": {\n                "contact-detail": {\n                    "type": "string",\n                    "default": "",\n                    "title": "The contact-detail Schema",\n                    "examples": [\n                        "/employee/:id/contact-detail"\n                    ]\n                },\n                "job-detail": {\n                    "type": "string",\n                    "default": "",\n                    "title": "The job-detail Schema",\n                    "examples": [\n                        "/employee/:id/job-detail"\n                    ]\n                },\n                "dependent": {\n                    "type": "string",\n                    "default": "",\n                    "title": "The dependent Schema",\n                    "examples": [\n                        "/employee/:id/dependent"\n                    ]\n                },\n                "supervisor": {\n                    "type": "string",\n                    "default": "",\n                    "title": "The supervisor Schema",\n                    "examples": [\n                        "/employee/:id/supervisor"\n                    ]\n                }\n            },\n            "examples": [{\n                "contact-detail": "/employee/:id/contact-detail",\n                "job-detail": "/employee/:id/job-detail",\n                "dependent": "/employee/:id/dependent",\n                "supervisor": "/employee/:id/supervisor"\n            }]\n        }\n    },\n    "examples": [{\n        "data": {\n            "firstName": "Megan",\n            "middleName": "Ult",\n            "lastName": "Van",\n            "code": "0027",\n            "employeeId": "116",\n            "fullName": "Megan Ult Van",\n            "status": null,\n            "dob": null,\n            "driversLicenseNumber": "",\n            "licenseExpiryDate": null,\n            "maritalStatus": null,\n            "gender": null,\n            "otherId": "",\n            "nationality": "Indonesian",\n            "unit": null,\n            "jobTitle": null,\n            "supervisor": null\n        },\n        "rels": {\n            "contact-detail": "/employee/:id/contact-detail",\n            "job-detail": "/employee/:id/job-detail",\n            "dependent": "/employee/:id/dependent",\n            "supervisor": "/employee/:id/supervisor"\n        }\n    }]\n}\n\t\n'

WS.validateJsonAgainstSchema(response1, jsonSchema, FailureHandling.STOP_ON_FAILURE)

response2 = WS.sendRequestAndVerify(findTestObject('Employee/04.Terminate Employment', [('success') : 'Successfully Terminated']))

//def slurper2 = new groovy.json.JsonSlurper()
//
//def result2 = slurper2.parseText(response2.getResponseBodyContent())
//
//String apiPostLoanResponse2 = response2.getResponseText()
//
//def value3 = result2.nationality
//
//GlobalVariable.nationality = value3

//WS.verifyResponseStatusCode(response2, 200)
//
//WS.verifyElementPropertyValue(response2, 'success', 'Successfully Terminated')

response3 = WS.sendRequestAndVerify(findTestObject('Employee/05.Employee Search'))

def slurper3 = new groovy.json.JsonSlurper()

def result4 = slurper3.parseText(response3.getResponseBodyContent())

String apiPostLoanResponse3 = response3.getResponseText()

def value4 = result4.employeeId

GlobalVariable.employeeId = value4

String jss1 = """
	{
	"\$schema": "https://json-schema.org/draft/2019-09/schema",
	"\$id": "http://example.com/example.json",
	"type": "object",
	"required": [
		"data",
		"rels"
	],
	"properties": {
		"data": {
			"type": "array",
			"items": {
				"type": "object",
				"required": [
					"firstName",
					"middleName",
					"lastName",
					"code",
					"employeeId",
					"fullName",
					"status",
					"dob",
					"driversLicenseNumber",
					"licenseExpiryDate",
					"maritalStatus",
					"gender",
					"otherId",
					"nationality",
					"unit",
					"jobTitle",
					"supervisor"
				],
				"properties": {
					"firstName": {
						"type": "string"
					},
					"middleName": {
						"type": "string"
					},
					"lastName": {
						"type": "string"
					},
					"code": {
						"type": "string"
					},
					"employeeId": {
						"type": "string"
					},
					"fullName": {
						"type": "string"
					},
					"status": {
						"type": "null"
					},
					"dob": {
						"type": "null"
					},
					"driversLicenseNumber": {
						"type": "string"
					},
					"licenseExpiryDate": {
						"type": "null"
					},
					"maritalStatus": {
						"type": "null"
					},
					"gender": {
						"type": "null"
					},
					"otherId": {
						"type": "string"
					},
					"nationality": {
						"type": "null"
					},
					"unit": {
						"type": "null"
					},
					"jobTitle": {
						"type": "null"
					},
					"supervisor": {
						"type": "null"
					}
				}
			}
		},
		"rels": {
			"type": "array",
			"items": {}
		}
	}
}

"""

WS.validateJsonAgainstSchema(response3, jss1, FailureHandling.STOP_ON_FAILURE)

WS.sendRequestAndVerify(findTestObject('Employee/05.Employee Search', [('data.[0].code') : GlobalVariable.employeeId]))

