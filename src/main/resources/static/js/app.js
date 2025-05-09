document.addEventListener('DOMContentLoaded', () => {
    fetch('/fruits')
        .then(response => response.json())
        .then(data => {
            const tbody = document.querySelector('tbody');
            tbody.innerHTML = '';
            data.forEach((item, index) => {
                const row = document.createElement('tr');
                row.innerHTML = `
            <th scope=\"row\">${index}</th>
            <td>${item.name}</td>
            <td>${item.description}</td>
          `
                index++;
                tbody.appendChild(row);
            });
        });
});