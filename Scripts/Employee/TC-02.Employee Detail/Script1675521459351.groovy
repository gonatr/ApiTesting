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

response = WS.sendRequest(findTestObject('Employee/02.Employee Detail'))

WS.verifyResponseStatusCode(response, 200)

WS.verifyElementPropertyValue(response, 'data.firstName', 'Megan')

WS.verifyElementPropertyValue(response, 'data.middleName', 'Ult')

WS.verifyElementPropertyValue(response, 'data.lastName', 'Van')

WS.verifyElementPropertyValue(response, 'data.code', '0027')

WS.verifyElementPropertyValue(response, 'data.fullName', 'Megan Ult Van')

String jsonSchema = 
"""
{
    "\$schema": "https://json-schema.org/draft/2019-09/schema",
    "\$id": "http://example.com/example.json",
    "type": "object",
    "default": {},
    "title": "Root Schema",
    "required": [
        "data",
        "rels"
    ],
    "properties": {
        "data": {
            "type": "object",
            "default": {},
            "title": "The data Schema",
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
                    "type": "string",
                    "default": "",
                    "title": "The firstName Schema",
                    "examples": [
                        "Megan"
                    ]
                },
                "middleName": {
                    "type": "string",
                    "default": "",
                    "title": "The middleName Schema",
                    "examples": [
                        "Ult"
                    ]
                },
                "lastName": {
                    "type": "string",
                    "default": "",
                    "title": "The lastName Schema",
                    "examples": [
                        "Van"
                    ]
                },
                "code": {
                    "type": "string",
                    "default": "",
                    "title": "The code Schema",
                    "examples": [
                        "0027"
                    ]
                },
                "employeeId": {
                    "type": "string",
                    "default": "",
                    "title": "The employeeId Schema",
                    "examples": [
                        "116"
                    ]
                },
                "fullName": {
                    "type": "string",
                    "default": "",
                    "title": "The fullName Schema",
                    "examples": [
                        "Megan Ult Van"
                    ]
                },
                "status": {
                    "type": "null",
                    "default": null,
                    "title": "The status Schema",
                    "examples": [
                        null
                    ]
                },
                "dob": {
                    "type": "null",
                    "default": null,
                    "title": "The dob Schema",
                    "examples": [
                        null
                    ]
                },
                "driversLicenseNumber": {
                    "type": "string",
                    "default": "",
                    "title": "The driversLicenseNumber Schema",
                    "examples": [
                        ""
                    ]
                },
                "licenseExpiryDate": {
                    "type": "null",
                    "default": null,
                    "title": "The licenseExpiryDate Schema",
                    "examples": [
                        null
                    ]
                },
                "maritalStatus": {
                    "type": "null",
                    "default": null,
                    "title": "The maritalStatus Schema",
                    "examples": [
                        null
                    ]
                },
                "gender": {
                    "type": "null",
                    "default": null,
                    "title": "The gender Schema",
                    "examples": [
                        null
                    ]
                },
                "otherId": {
                    "type": "string",
                    "default": "",
                    "title": "The otherId Schema",
                    "examples": [
                        ""
                    ]
                },
                "nationality": {
                    "type": "string",
                    "default": "",
                    "title": "The nationality Schema",
                    "examples": [
                        "Indonesian"
                    ]
                },
                "unit": {
                    "type": "null",
                    "default": null,
                    "title": "The unit Schema",
                    "examples": [
                        null
                    ]
                },
                "jobTitle": {
                    "type": "null",
                    "default": null,
                    "title": "The jobTitle Schema",
                    "examples": [
                        null
                    ]
                },
                "supervisor": {
                    "type": "null",
                    "default": null,
                    "title": "The supervisor Schema",
                    "examples": [
                        null
                    ]
                }
            },
            "examples": [{
                "firstName": "Megan",
                "middleName": "Ult",
                "lastName": "Van",
                "code": "0027",
                "employeeId": "116",
                "fullName": "Megan Ult Van",
                "status": null,
                "dob": null,
                "driversLicenseNumber": "",
                "licenseExpiryDate": null,
                "maritalStatus": null,
                "gender": null,
                "otherId": "",
                "nationality": "Indonesian",
                "unit": null,
                "jobTitle": null,
                "supervisor": null
            }]
        },
        "rels": {
            "type": "object",
            "default": {},
            "title": "The rels Schema",
            "required": [
                "contact-detail",
                "job-detail",
                "dependent",
                "supervisor"
            ],
            "properties": {
                "contact-detail": {
                    "type": "string",
                    "default": "",
                    "title": "The contact-detail Schema",
                    "examples": [
                        "/employee/:id/contact-detail"
                    ]
                },
                "job-detail": {
                    "type": "string",
                    "default": "",
                    "title": "The job-detail Schema",
                    "examples": [
                        "/employee/:id/job-detail"
                    ]
                },
                "dependent": {
                    "type": "string",
                    "default": "",
                    "title": "The dependent Schema",
                    "examples": [
                        "/employee/:id/dependent"
                    ]
                },
                "supervisor": {
                    "type": "string",
                    "default": "",
                    "title": "The supervisor Schema",
                    "examples": [
                        "/employee/:id/supervisor"
                    ]
                }
            },
            "examples": [{
                "contact-detail": "/employee/:id/contact-detail",
                "job-detail": "/employee/:id/job-detail",
                "dependent": "/employee/:id/dependent",
                "supervisor": "/employee/:id/supervisor"
            }]
        }
    },
    "examples": [{
        "data": {
            "firstName": "Megan",
            "middleName": "Ult",
            "lastName": "Van",
            "code": "0027",
            "employeeId": "116",
            "fullName": "Megan Ult Van",
            "status": null,
            "dob": null,
            "driversLicenseNumber": "",
            "licenseExpiryDate": null,
            "maritalStatus": null,
            "gender": null,
            "otherId": "",
            "nationality": "Indonesian",
            "unit": null,
            "jobTitle": null,
            "supervisor": null
        },
        "rels": {
            "contact-detail": "/employee/:id/contact-detail",
            "job-detail": "/employee/:id/job-detail",
            "dependent": "/employee/:id/dependent",
            "supervisor": "/employee/:id/supervisor"
        }
    }]
}
	
"""

WS.validateJsonAgainstSchema(response, jsonSchema, FailureHandling.STOP_ON_FAILURE)

