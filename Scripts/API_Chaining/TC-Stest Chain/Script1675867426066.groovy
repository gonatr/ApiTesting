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

response = WS.sendRequest(findTestObject('API_Chaining/01.Save Employee'))

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(response.getResponseBodyContent())

String apiPostLoanResponse = response.getResponseText()

//def value = result.data.nationality
def value1 = result

GlobalVariable.employeeId = value1

GlobalVariable.nationality = 'Indian'

response1 = WS.sendRequestAndVerify(findTestObject('API_Chaining/02.Employee Detail'))

def slurper1 = new groovy.json.JsonSlurper()

def result1 = slurper1.parseText(response1.getResponseBodyContent())

String apiPostLoanResponse1 = response1.getResponseText()

def value2 = result1.nationality

//GlobalVariable.userName = value2
//println ("adsfsdafsdf "+ value1)
WS.sendRequest(findTestObject('Reqress/UpdateUser', [('success') : 'Successfully Updated']))

