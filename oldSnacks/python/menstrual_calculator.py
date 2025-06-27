from datetime import datetime, timedelta

def get_first_day():
    while True:
        try:
            first_day = input("Enter the first day of your menstrual cycle (dd/MM/yyyy): ")
            return datetime.strptime(first_day, "%d/%m/%Y")
        except ValueError:
            print("Invalid date format. Please use dd/MM/yyyy.")

def get_cycle_length():
    while True:
        try:
            length = int(input("Enter your average cycle length: "))
            if length > 0:
                return length
            else:
                print("Cycle length must be a positive integer.")
        except ValueError:
            print("Invalid input. Please enter a valid number.")

def calculate_ovulation_date(first_day_date, cycle_length):
    return first_day_date + timedelta(days=(cycle_length - 14))

def calculate_fertile_window(ovulation_date):
    start_fertile = ovulation_date - timedelta(days=5)
    end_fertile = ovulation_date + timedelta(days=1)
    return start_fertile, end_fertile

def display_results(ovulation_date, fertile_window):
    print(f"\nYour next Ovulation Date is: {ovulation_date.strftime('%d/%m/%Y')}")
    print(f"If there is no fertilization, your hormone level starts dropping from: "
          f"{fertile_window[0].strftime('%d/%m/%Y')} to {fertile_window[1].strftime('%d/%m/%Y')}")

def ask_to_continue():
    while True:
        user_choice = input("\nDo you want to continue? (yes/no): ").strip().lower()
        if user_choice == "yes":
            return True
        elif user_choice == "no":
            print("Thank you for using the Menstrual Calculator.")
            return False
        else:
            print("Invalid input. Please enter 'yes' or 'no'.")