package com.shilong;import java.util.*;

public class BitmapIndex {

	// 位图索引结构
	private Map<String, Map<String, BitSet>> bitmapIndex;

	public BitmapIndex() {
		this.bitmapIndex = new HashMap<>();
		initializeBitmapIndex();
	}

	// 初始化位图索引
	private void initializeBitmapIndex() {
		// 示例商品总数：5个商品
		int totalProducts = 5;

		// 1. 分类维度
		Map<String, BitSet> categoryBitmap = new HashMap<>();
		BitSet electronicsBitSet = new BitSet(totalProducts);
		electronicsBitSet.set(0); // 商品1属于Electronics
		electronicsBitSet.set(1); // 商品2属于Electronics
		electronicsBitSet.set(2); // 商品3属于Electronics
		categoryBitmap.put("Electronics", electronicsBitSet);

		BitSet clothingBitSet = new BitSet(totalProducts);
		clothingBitSet.set(3); // 商品4属于Clothing
		clothingBitSet.set(4); // 商品5属于Clothing
		categoryBitmap.put("Clothing", clothingBitSet);
		bitmapIndex.put("category", categoryBitmap);

		// 2. 价格区间维度
		Map<String, BitSet> priceRangeBitmap = new HashMap<>();
		BitSet priceRange1BitSet = new BitSet(totalProducts);
		priceRange1BitSet.set(0); // 商品1价格在100-200
		priceRange1BitSet.set(3); // 商品4价格在100-200
		priceRangeBitmap.put("100-200", priceRange1BitSet);

		BitSet priceRange2BitSet = new BitSet(totalProducts);
		priceRange2BitSet.set(1); // 商品2价格在200-300
		priceRange2BitSet.set(4); // 商品5价格在200-300
		priceRangeBitmap.put("200-300", priceRange2BitSet);
		bitmapIndex.put("priceRange", priceRangeBitmap);

		// 3. 品牌维度
		Map<String, BitSet> brandBitmap = new HashMap<>();
		BitSet appleBitSet = new BitSet(totalProducts);
		appleBitSet.set(1); // 商品2属于Apple
		appleBitSet.set(4); // 商品5属于Apple
		brandBitmap.put("Apple", appleBitSet);

		BitSet samsungBitSet = new BitSet(totalProducts);
		samsungBitSet.set(0); // 商品1属于Samsung
		samsungBitSet.set(3); // 商品4属于Samsung
		brandBitmap.put("Samsung", samsungBitSet);
		bitmapIndex.put("brand", brandBitmap);
	}

	/**
	 * 使用位图索引查询符合条件的商品ID
	 *
	 * @param conditions 查询条件，例如：category->"Electronics"、priceRange->"100-200"等
	 * @return 符合条件的商品ID列表
	 */
	public List<Integer> queryProducts(Map<String, String> conditions) {
		BitSet resultBitmap = null;
		boolean firstCondition = true;

		// 遍历每个查询条件
		for (Map.Entry<String, String> condition : conditions.entrySet()) {
			String directType = condition.getKey();   // 维度类型，例如 category、priceRange、brand
			String directValue = condition.getValue(); // 具体值，例如 "Electronics"、"100-200"、"Apple"

			Map<String, BitSet> directTypeBitmap = bitmapIndex.get(directType);

			if (directTypeBitmap != null) {
				BitSet conditionBitmap = directTypeBitmap.get(directValue);

				if (conditionBitmap != null) {
					if (firstCondition) {
						resultBitmap = (BitSet) conditionBitmap.clone(); // 初次查询直接赋值
						firstCondition = false;
					} else {
						resultBitmap.and(conditionBitmap); // 执行位图的AND操作
					}
				}
			}
		}

		// 将位图转换为商品ID列表
		List<Integer> result = new ArrayList<>();
		if (resultBitmap != null) {
			for (int i = resultBitmap.nextSetBit(0); i >= 0; i = resultBitmap.nextSetBit(i + 1)) {
				result.add(i + 1); // 商品ID从1开始
			}
		}

		return result;
	}

	public static void main(String[] args) {
		BitmapIndex system = new BitmapIndex();

		// 定义多维条件查询
		Map<String, String> conditions = new HashMap<>();
		conditions.put("category", "Electronics");
		conditions.put("priceRange", "100-200");
		conditions.put("brand", "Samsung");

		// 查询商品
		List<Integer> products = system.queryProducts(conditions);
		System.out.println("符合条件的商品ID：" + products);
	}
}
