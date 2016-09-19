Sub main()
	Dim k As Integer = 0
	Dim n As Boolean = False
	Dim m As String = "Hola Mundo"
	For index As Integer = 1 To 100000
    	' If index is between 5 and 7, continue
    	' with the next iteration.
    	If index >= 5 And index <= 8 Then
    	End If

    	' If index is 10, exit the loop.
    	If index = 10 Then
        	
    	End If
	Next
End Sub

Function operaciones(ByVal num1 As Integer, ByRef num2 As Integer)
	num2 = 2
	num2 = 4
	Dim sumar As Integer = 0
	Dim restar As Integer = 0
	Dim multiplicar As Integer = 0
	Dim dividir As Integer = 0


	sumar = num1+num2
	restar = num2-num1
	multiplicar = num1*num2
	dividir = num1/num2

	Dim index As Integer = 0
	Do While index <= 100
    	If index > 10 Then

    	End If

    	'index += 1
	Loop
	Return 0
End Function
