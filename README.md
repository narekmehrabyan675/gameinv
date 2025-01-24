
InvertorySimulation
# Item Upgrade System

## Overview
The **Item Upgrade System** is a Java application designed to simulate an item inventory and upgrade mechanics based on rarity levels. This system allows for random item generation, upgrades based on predefined rules, and inventory management. It can be run using an IDE such as IntelliJ IDEA or Eclipse.

## Features
1. Random item generation with weighted probabilities for rarities:
   - **COMMON:** 50%
   - **GREAT:** 25%
   - **RARE:** 15%
   - **EPIC:** 8%
   - **LEGENDARY:** 2%
2. Upgrade mechanics for items:
   - Items can be upgraded by combining multiple items of the same type and rarity.
   - New items will have updated rarity and names based on upgrade rules.
3. Inventory management:
   - Display inventory before and after upgrades.
   - Save and load inventory to/from a file.

## Assumptions and Design Choices
1. **Random Item Names:**
   - Each rarity level has a predefined name:
     - COMMON: "Sword"
     - GREAT: "Shield"
     - RARE: "Wand"
     - EPIC: "Bow"
     - LEGENDARY: "Staff"
2. **Upgrade Rules:**
   - Items of the same rarity are combined into one upgraded item with the next rarity.
   - Names are automatically updated based on the new rarity.
3. **Execution Environment:**
   - The application is designed to run from an IDE using the `Main` class.

## Prerequisites
1. **Java Development Kit (JDK)**: Ensure that JDK 17 or later is installed on your machine.
2. **IDE**: Use IntelliJ IDEA, Eclipse, or any other Java IDE.

## How to Compile and Run
### Steps to Run the Application in an IDE

### Steps to Run After Downloading from GitHub
1. Download the repository as a ZIP file from GitHub.
2. Extract the ZIP file to a directory on your system.
3. Open IntelliJ IDEA and choose **Open Project**.
4. Navigate to the extracted folder and select it.
5. Wait for IntelliJ IDEA to load and index the project.
6. Locate the `Main` class in the project structure.
7. Right-click on the `Main` class and select **Run 'Main'**.

### You can run via Git without downloading.But recomended using download(first) version.
1. **Clone the Repository**:
   ```
   git clone <repository_url>
   ```
2. **Open the Project**:
   - Launch your IDE (e.g., IntelliJ IDEA).
   - Open the cloned repository as a project.
3. **Set the Main Class**:
   - Navigate to the `Main` class in the project structure.
   - Ensure the `Main` class contains the `main` method.
4. **Run the Application**:
   - Click the **Run** button in the IDE toolbar or right-click on the `Main` class and select `Run 'Main'`.
   

### Expected Output
The program will:
1. Generate random items with appropriate names and rarities.
2. Display the inventory before and after upgrades.
3. Save the inventory to a file (`inventory.txt`) and load it back.

### Example Execution Flow
1. **Generate Items**:
   - Displays generated items with rarity and names.
2. **Upgrade Items**:
   - Combines items of the same rarity to create upgraded items.
   - Updates names and rarities.
3. **Final Inventory**:
   - Shows the final state of the inventory after all upgrades.

## File Structure
- `Main.java`: Entry point for the application.
- `Item.java`: Represents individual items.
- `ItemUpgradeSystem.java`: Handles upgrade mechanics.
- `RandomItemGenerator.java`: Generates random items.
- `InventorySaver.java`: Saves inventory to a file.
- `InventoryLoader.java`: Loads inventory from a file.

## Troubleshooting
1. **Error: "Could not find or load main class"**
   - Ensure the `Main` class is marked as the entry point.
   - Rebuild the project if necessary.
2. **FileNotFoundException for `inventory.txt`**:
   - Ensure the file is in the correct directory or use absolute paths.
3. **No Upgrades Performed**:
   - Ensure sufficient items of the same rarity and name are generated.

## Contact
For questions or feedback, feel free to open an issue on the GitHub repository.

