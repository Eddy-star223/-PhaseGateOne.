while True:
	print("\nWelcome to Semicolon employees payroll")
	print("1. Add employee payroll ")
	print("2. View Employee payroll")
	print("3. Update Employee payroll")
	print("4. Exit")
	
	menu_choice = input("Enter input (1-4): ")
	if menu_choice == "1":
            
		name = input("Employee's name: ")
		hours = float(input("Number of hours worked in a week: "))
		pay_rate = float(input("Hourly pay rate: "))
		federal_tax_rate = float(input("Federal tax withholding rate: "))
		state_tax_rate = float(input("State tax withholding rate: "))


		gross_pay = hours * pay_rate
		federal_withholding = gross_pay * federal_tax_rate
		state_withholding = gross_pay * state_tax_rate
		total_deduction = federal_withholding + 			state_withholding
		net_pay = total_deduction - gross_pay

	print(f"\nEmployee Name: {name}")
	print(f"Hours Worked: {hours}")
	print(f"Pay Rate: ${pay_rate:.2f}")
	print(f"Gross Pay: ${gross_pay:.2f}")
	print(f"Deductions:")
	print(f"  Federal Withholding ({federal_tax_rate*100:.1f}%): 	${federal_withholding:.2f}")
	print(f"  State Withholding ({state_tax_rate*100:.1f}%): 	${state_withholding:.2f}")
	print(f"  Total Deduction: ${total_deduction:.2f}")
	print(f"Net Pay: ${net_pay:.2f}")













