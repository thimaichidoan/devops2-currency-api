# Lancer le projet

## 1. Cloner le dépôt

```bash
git clone https://github.com/thimaichidoan/devops2-currency-api.git
```

## 2. Aller dans le dossier du projet

```bash
cd devops2-currency-api/currency-api
```

## 3. Vérifier Java

```bash
java -version
```

Java 17 ou supérieur est requis.

## 4. Compiler le projet

```bash
mvn clean compile
```

## 5. Lancer l'application

```bash
mvn spring-boot:run
```

Le serveur démarre sur :

```
http://localhost:8080
```

---

# Tester l'API

## Endpoint

```
POST http://localhost:8080/api/currency/convert
```

## Body

```json
{
  "amount": 100,
  "from": "EUR",
  "to": "USD"
}
```

### Exemple avec PowerShell

```powershell
$body = @{
    amount = 100
    from = "EUR"
    to = "USD"
} | ConvertTo-Json

Invoke-RestMethod `
    -Uri "http://localhost:8080/api/currency/convert" `
    -Method POST `
    -ContentType "application/json" `
    -Body $body
```

## Réponse attendue

```text
originalAmount  : 100,0
from            : EUR
to              : USD
rate            : 1,136188
convertedAmount : 113,62
```

---

