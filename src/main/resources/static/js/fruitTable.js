import {createFruit, deleteFruit, fetchFruits, updateFruit} from './fruitService.js';

const fields = ['name', 'description', 'category', 'origin', 'color'];

// Build a <tr> element for one fruit
function buildRow(item) {
    const tr = document.createElement('tr');
    tr.dataset.id = item.id;
    tr.innerHTML = `
    <th scope="row">${item.id}</th>
    ${fields.map(field =>
        `<td data-field="${field}" class="cell ${field}-cell">
         ${item[field]}
       </td>`
    )
        .join('')}
    <td class="text-end">
      <button class="btn btn-link p-0 edit-btn">
        <i class="bi bi-pencil-square"></i>
      </button>
      <button class="btn btn-link p-0 delete-btn">
        <i class="bi bi-trash"></i>
      </button>
    </td>
  `;
    return tr;
}

// Load fruits into the given tbody element
export async function initFruitTable(tbody) {
    //Render initial list
    try {
        const list = await fetchFruits();
        tbody.innerHTML = '';
        list.forEach(item => tbody.appendChild(buildRow(item)));
    } catch (err) {
        console.error(err);
    }

//Event delegation for edit and delete buttons
    tbody.addEventListener('click', async (e) => {
        const btn = e.target.closest('button');
        if (!btn) return;
        const row = btn.closest('tr');
        const id = row.dataset.id;

        if (btn.matches('.edit-btn')) {
            await handleEdit(row, id, btn);
        } else if (btn.matches('.delete-btn')) {
            await handleDelete(row, id);
        }
    });
}

//Toggle edit/save mode for one row
async function handleEdit(row, id, btn) {
    const icon = btn.querySelector('i');
    const editing = row.classList.toggle('editing');
    const cells = Array.from(row.querySelectorAll('td[data-field]'));

    if (editing) {
        cells.forEach(td => {
            td.innerHTML = `<input type="text" class="form-control w-100" value="${td.textContent.trim()}">`;
            icon.className = "bi bi-check-square";
        })
    } else {
        //Collect payload from inputs
        const payload = cells.reduce((obj, td) => {
            obj[td.dataset.field] = td.querySelector('input').value;
            return obj;
        }, {});

        try {
            const updated = await updateFruit(id, payload);
            cells.forEach(td => {
                td.textContent = updated[td.dataset.field];
            });
        } catch (err) {
            console.error(err);
        }
    }
}

//Delete a row
async function handleDelete(row, id) {
    if (!confirm(`Are you sure you want to delete fruit with ID ${id}?`)) return;
    try {
        await deleteFruit(id);
        row.remove();
    } catch (err) {
        console.error("Delete failed: ", err);
    }
}

async function addFruit(tbody, newFruit) {
    try {
        const fruit = await createFruit(newFruit);
        tbody.appendChild(buildRow(fruit));
    } catch (err) {
        console.error("Create failed: ", err);
    }
}