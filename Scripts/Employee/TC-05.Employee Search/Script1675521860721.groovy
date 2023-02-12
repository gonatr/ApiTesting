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

response = WS.sendRequest(findTestObject('Employee/05.Employee Search'))

WS.verifyResponseStatusCode(response, 200)

WS.verifyElementPropertyValue(response, 'data[0].firstName', 'Megan')

String jschema = """
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

//WS.validateJsonAgainstSchema(response,jschema)
WS.validateJsonAgainstSchema(response, jschema, FailureHandling.STOP_ON_FAILURE)

//WS.validateJsonAgainstSchema(response, jshema, FailureHandling.STOP_ON_FAILURE)

