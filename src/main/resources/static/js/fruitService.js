const API_BASE = "/fruits";

export async function fetchFruits() {
    const res = await fetch(API_BASE);
    if (!res.ok) throw new Error("Failed to fetch fruits");
    return res.json();
}

export async function updateFruit(id, payload) {
    const res = await fetch(`${API_BASE}/${id}`, {
        method: 'PUT',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(payload)
    });
    if (!res.ok) throw new Error("Failed to update fruit");
    return res.json();
}

export async function deleteFruit(id) {
    const res = await fetch(`${API_BASE}/${id}`, {
        method: 'DELETE'
    });
    if (!res.ok) throw new Error("Failed to delete fruit");

    return res.json();
}

export async function createFruit(newFruit) {
    const res = await fetch(API_BASE, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(newFruit)
    });
    if (!res.ok) throw new Error("Failed to create fruit");
    return res.json();
}