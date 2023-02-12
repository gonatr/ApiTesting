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

response = WS.sendRequest(findTestObject('Admin/03.Get Organization Information'))

WS.verifyResponseStatusCode(response, 200)

WS.verifyElementPropertyValue(response, 'data.id', 1)

WS.verifyElementPropertyValue(response, 'data.name', 'Sekolah Digital Cilsy')

String jss = """
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
			"type": "object",
			"required": [
				"id",
				"name",
				"taxId",
				"registraionNumber",
				"phone",
				"fax",
				"email",
				"country",
				"province",
				"city",
				"zipCode",
				"street1",
				"street2",
				"note",
				"numberOfEmployees"
			],
			"properties": {
				"id": {
					"type": "string"
				},
				"name": {
					"type": "string"
				},
				"taxId": {
					"type": "null"
				},
				"registraionNumber": {
					"type": "null"
				},
				"phone": {
					"type": "null"
				},
				"fax": {
					"type": "null"
				},
				"email": {
					"type": "null"
				},
				"country": {
					"type": "string"
				},
				"province": {
					"type": "null"
				},
				"city": {
					"type": "null"
				},
				"zipCode": {
					"type": "null"
				},
				"street1": {
					"type": "null"
				},
				"street2": {
					"type": "null"
				},
				"note": {
					"type": "null"
				},
				"numberOfEmployees": {
					"type": "integer"
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

WS.validateJsonAgainstSchema(response, jss)

