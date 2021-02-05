<html>
<body>
<table>
    <tr>
        <th>Account ID</th>
        <th>Account NR</th>
        <th>Balance</th>
        <th>Customer ID FKey</th>
    </tr>
    <?php
    $conn = mysqli_connect("localhost", "postgres", "paroolideparool", "jdbc");
    $sql = "SELECT * FROM account";
    $result = $conn->query($sql);

    if ($result->num_rows > 0) {
        while ($row = $result->fetch_assoc()) {
            echo "<td></td>" . $row["account_number"] . "<td></td>" . $row["balance"] . "<td></td>" . $row["customer_id_key"] . "<td></td>";
        }
    } else {
        echo "No Results";
    }
    $conn->close();
    ?>

</table>
</body>
</html>