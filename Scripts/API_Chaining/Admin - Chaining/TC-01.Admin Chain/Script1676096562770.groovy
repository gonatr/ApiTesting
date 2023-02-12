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

response = WS.sendRequestAndVerify(findTestObject('Admin/01.Get Users'))

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(response.getResponseBodyContent())

String apiPostLoanResponse = response.getResponseText()

def value = result.data[0].employeeId

GlobalVariable.employeeId = value

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
                    "userName",
                    "userRole",
                    "status",
                    "employeeName",
                    "employeeId"
                ],
                "properties": {
                    "userName": {
                        "type": "string"
                    },
                    "userRole": {
                        "type": "string"
                    },
                    "status": {
                        "type": "string"
                    },
                    "employeeName": {
                        "type": "string"
                    },
                    "employeeId": {
                        "type": "string"
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

response1 = WS.sendRequestAndVerify(findTestObject('Admin/02.User Login', [('user.employeeId') : GlobalVariable.employeeId]))

def slurper1 = new groovy.json.JsonSlurper()

def result1 = slurper1.parseText(response1.getResponseBodyContent())

String apiPostLoanResponse1 = response1.getResponseText()

def value3 = result1.user.employeeId

WS.sendRequestAndVerify(findTestObject('Admin/03.Get Organization Information', [('data.id') : value3]))

