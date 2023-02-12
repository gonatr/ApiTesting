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

response = WS.sendRequest(findTestObject('Admin/02.User Login'))

WS.verifyResponseStatusCode(response, 200)

WS.verifyElementPropertyValue(response, 'login', true)

WS.verifyElementPropertyValue(response, 'user.userName', 'tonyaUV')

WS.verifyElementPropertyValue(response, 'user.userRole', 'ESS')

String jss = """
	{
	"\$schema": "https://json-schema.org/draft/2019-09/schema",
	"\$id": "http://example.com/example.json",
	"type": "object",
	"required": [
		"login",
		"user"
	],
	"properties": {
		"login": {
			"type": "boolean"
		},
		"user": {
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
	}
}

"""

WS.validateJsonAgainstSchema(response, jss)

