.data
_a: .word 10
_b: .word 30
_c: .word 20
_msg1: .asciiz "If dentro del If se cumplio"
_msg2: .asciiz "If dentro del If se NO cumplio"
_msg3: .asciiz "True"
_msg4: .asciiz "False"

.text
.globl main

main:
	lw $t0, _a
	lw $t1, _b
	blt $t0, $t1, _etiqueta0
	b _etiqueta5

_etiqueta0:

	lw $t0, _b
	lw $t1, _c
	bge $t0, $t1, _etiqueta1
	b _etiqueta5

_etiqueta1:

	lw $t0, _b
li $t1, 20
	bne $t0, $t1, _etiqueta2
	b _etiqueta6

_etiqueta2:

	li $v0, 4
	la $a0,_msg1
	syscall

	b _etiqueta6

_etiqueta3:

	li $v0, 4
	la $a0,_msg2
	syscall

_etiqueta4:

	li $v0, 4
	la $a0,_msg3
	syscall

	b _etiqueta6

_etiqueta5:

	li $v0, 4
	la $a0,_msg4
	syscall

_etiqueta6:


	li $v0,10
	syscall
