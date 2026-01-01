import os
import shutil

CLASS_FOLDER = "Class"
CURRENT_DIR = os.getcwd()

def organize_class_files():
    # Create Class folder if it does not exist
    class_path = os.path.join(CURRENT_DIR, CLASS_FOLDER)
    if not os.path.exists(class_path):
        os.mkdir(class_path)
        print("Class folder created.")

    moved = False
    for file in os.listdir(CURRENT_DIR):
        if file.endswith(".class") and os.path.isfile(file):
            shutil.move(file, class_path)
            moved = True

    if moved:
        print(".class files moved to Class folder.")
    else:
        print("No .class files found.")


def make_running_environment():
    class_path = os.path.join(CURRENT_DIR, CLASS_FOLDER)

    if not os.path.exists(class_path):
        print("No file.")
        return

    files = os.listdir(class_path)
    class_files = [f for f in files if f.endswith(".class")]

    if not class_files:
        print("No file.")
        return

    for file in class_files:
        shutil.move(os.path.join(class_path, file), CURRENT_DIR)

    print(".class files moved back to main folder.")


# ================= MAIN MENU =================
print("1. Keep organized class file")
print("2. Make running environment")

choice = input("Enter your choice (1 or 2): ")

if choice == "1":
    organize_class_files()
elif choice == "2":
    make_running_environment()
else:
    print("Invalid choice.")
